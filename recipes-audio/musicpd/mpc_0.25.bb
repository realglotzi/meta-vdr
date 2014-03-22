DESCRIPTION = "Command-line (scriptable) Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
SECTION = "console/multimedia"

DEPENDS = "virtual/libiconv libmpdclient"

PR = "r3"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "http://www.musicpd.org/download/mpc/0/mpc-${PV}.tar.xz \
           file://next_mpd_playlist.sh"

inherit autotools useradd

do_install_append() {
    install ${WORKDIR}/next_mpd_playlist.sh ${D}${bindir}
    chmod +x ${D}${bindir}/next_mpd_playlist.sh

    install -d ${D}/${localstatedir}/lib/mpd
    touch ${D}/${localstatedir}/lib/mpd/current_playlist_index
    chown mpd:mpd ${D}/${localstatedir}/lib/mpd/current_playlist_index
    chmod ug+w ${D}/${localstatedir}/lib/mpd/current_playlist_index
}

FILES_${PN} += "${localstatedir}/lib/mpd/*"

SRC_URI[md5sum] = "76aec8e973e3c6c131e9e9f2ad8f34c3"
SRC_URI[sha256sum] = "70cfa4f734a275a3c76df481ec5222872362ed8f58a4175459cae65d66acaf24"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/lib/mpd \
    --groups audio \
    --user-group mpd"