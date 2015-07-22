DESCRIPTION = "Music Player Daemon"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
HOMEPAGE ="www.musicpd.org"

DEPENDS = "boost icu alsa-lib libsamplerate0 libsndfile1 libvorbis libogg faad2 flac curl sqlite bzip2 libmpdclient libmad lame libnfs avahi"

PR = "r0"

SRC_URI = " \
    http://www.musicpd.org/download/${PN}/stable/${PN}-${PV}.tar.xz \
	file://mpd \
    file://mpd.conf.in \
"

SRC_URI[md5sum] = "da4bc3e47afd0faf9e7a67168e012102"
SRC_URI[sha256sum] = "c386eb3d22f98dc993b5ae3c272f969aa7763713483c6800040ebf1791b15851"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools useradd update-rc.d

EXTRA_OECONF = "enable_bzip2=yes"
EXTRA_OECONF += "enable_mad=yes"
EXTRA_OECONF += "enable_id3=yes"
EXTRA_OECONF += "enable_libmpdclient=yes"
EXTRA_OECONF += "enable_nfs=yes"
EXTRA_OECONF += "enable_upnp=no"
EXTRA_OECONF += "enable_avahi=yes"

INITSCRIPT_NAME = "mpd"
INITSCRIPT_PARAMS = "defaults 75"

FILES_${PN} += "${sysconfdir}/init.d/* /var/*"

do_install_append() {
    install -d ${D}/${localstatedir}/lib/mpd/music
    chmod 775 ${D}/${localstatedir}/lib/mpd/music
    install -d ${D}/${localstatedir}/lib/mpd/playlists

    install -d ${D}/${sysconfdir}
    install -m 644 ${WORKDIR}/mpd.conf.in ${D}/${sysconfdir}/mpd.conf_sample
	
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/mpd ${D}${sysconfdir}/init.d/

    chown -R mpd:mpd ${D}/${localstatedir}/lib/mpd

    install -d ${D}${sysconfdir}/default/volatiles
    echo "d mpd mpd 0775 ${localstatedir}/run/mpd none" \
        > ${D}${sysconfdir}/default/volatiles/99_mpd
    echo "d mpd mpd 0775 ${localstatedir}/log/mpd none" \
        >> ${D}${sysconfdir}/default/volatiles/99_mpd	
}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/lib/mpd \
    --groups audio \
    --user-group mpd"
