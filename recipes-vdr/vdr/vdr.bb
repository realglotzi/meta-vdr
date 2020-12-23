DESCRIPTION = "Video Disk Recorder (VDR) is a digital sat-receiver program using Linux and DVB technologies. It allows to record broadcasts, as well as output the stream to TV."
SUMMARY = "Video Disk Recorder"
HOMEPAGE = "http://www.tvdr.de"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
AUTHOR = "Klaus Schmidinger"

PR="r9"

SRC_URI = "git://git.tvdr.de/vdr.git"
SRCREV = "d2e0087c4e13b2acbecc4bafb3cb2ab656c95339"

S = "${WORKDIR}/git"

# the current version
#PV = "2.4.6"

#SRC_URI = "ftp://ftp.tvdr.de/vdr/${P}.tar.bz2"

#SRC_URI[md5sum] = "aa91614159ae2db45655d35918e2c24e"
#SRC_URI[sha256sum] = "c8993babf2a878a0fba84558de1e35f042c3c66f7c1ec569eea00a3af1014e4b"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI_append = " \
        file://vdr.service \
        file://MainMenuHooks-v1_0_3.patch \
        file://vdr-2.2.0-missing-plugin.patch \
        file://vdr-2.4.0_zapcockpit.patch \
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

