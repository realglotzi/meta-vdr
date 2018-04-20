SUMMARY = "DVB Frontend Status Monitor plugin for VDR"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r4"

SRC_URI = "git://github.com/rofafor/vdr-plugin-femon.git"
SRCREV  = "28e4fb8de8578a1b8a36eb38d2e710dc60be7e3f"

S = "${WORKDIR}/git"

inherit pkgconfig gettext

DEPENDS = "vdr"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' STRIP=/bin/true '

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} += " \
	${libdir}/vdr/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"

