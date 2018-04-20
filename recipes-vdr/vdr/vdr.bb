DESCRIPTION = "Video Disk Recorder (VDR) is a digital sat-receiver program using Linux and DVB technologies. It allows to record broadcasts, as well as output the stream to TV."
SUMMARY = "Video Disk Recorder"
HOMEPAGE = "http://www.tvdr.de"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
AUTHOR = "Klaus Schmidinger"

PR="r0"

# the current version
PV = "2.4.0"

SRC_URI = "ftp://ftp.tvdr.de/vdr/${P}.tar.bz2"

SRC_URI[md5sum] = "12c6a3abeadfa915fcfe736bb047a3ab"
SRC_URI[sha256sum] = "93af49fe87048073dc38ef5e6c71e9704344d730f21c261afac69e3c937f8cce"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI_append = " \
        file://vdr.service \
	file://MainMenuHooks-v1_0_3.patch \
        file://vdr-2.2.0-missing-plugin.patch \
        file://vdr-2.3.4_zapcockpit.patch \
"

inherit systemd pkgconfig gettext

DEPENDS = " \
	fontconfig \
	freetype \
	ttf-bitstream-vera \
	gettext \
	jpeg \
	libcap \
	virtual/libintl \
	ncurses \
"

RDEPENDS_${PN} += "perl"

PLUGINDIR = "${libdir}/vdr"

CXXFLAGS = "-fPIC"
CFLAGS = "-fPIC"

do_configure_append() {
    cat > Make.config <<-EOF
	## The C compiler options:
	CFLAGS   = ${CFLAGS} -Wall
	CXXFLAGS = ${CFLAGS} -Wall
	### The directory environment:
	PREFIX   = ${prefix}
	BINDIR   = ${bindir}
	INCDIR   = ${includedir}
	LIBDIR   = ${libdir}/vdr
	LOCDIR   = ${datadir}/locale
	MANDIR   = ${mandir}
	PCDIR    = ${libdir}/pkgconfig
	RESDIR   = ${datadir}/vdr

	VIDEODIR = /srv/vdr/video
	CONFDIR  = ${sysconfdir}/vdr
	ARGSDIR  = ${sysconfdir}/vdr/conf.d
	CACHEDIR = /var/cache/vdr
	EOF
}

do_compile () {
	oe_runmake 'DESTDIR=${D}' vdr
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install-bin install-i18n install-includes install-pc

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/vdr.service ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "vdr.service" 
RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"

FILES_${PN} = "${bindir}/* ${localstatedir}/cache/vdr ${datadir}/vdr ${systemd_unitdir}/system/vdr.service"

FILES_${PN}-dbg += "${PLUGINDIR}/.debug/*"

FILES_${PN}-locale = "${datadir}/locale"

