DESCRIPTION = "Command-line (scriptable) Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
SECTION = "console/multimedia"

DEPENDS = "virtual/libiconv libmpdclient"

PR = "r4"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "http://www.musicpd.org/download/mpc/0/mpc-${PV}.tar.xz \
           file://next_mpd_playlist.sh"

inherit autotools useradd pkgconfig

do_install_append() {
    install ${WORKDIR}/next_mpd_playlist.sh ${D}${bindir}
    chmod +x ${D}${bindir}/next_mpd_playlist.sh

    install -d ${D}/${localstatedir}/lib/mpd
    touch ${D}/${localstatedir}/lib/mpd/current_playlist_index
    chown mpd:mpd ${D}/${localstatedir}/lib/mpd/current_playlist_index
    chmod ug+w ${D}/${localstatedir}/lib/mpd/current_playlist_index
}

FILES_${PN} += "${localstatedir}/lib/mpd/*"

SRC_URI[md5sum] = "d4f37e7e6b32c804a870192d1eb86199"
SRC_URI[sha256sum] = "20735f7173cce56bec50c1d8b4633751052dc68365b29a6113206dc1cdc6e242"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/lib/mpd \
    --groups audio \
    --user-group mpd"
