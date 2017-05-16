SUMMARY = "VDR satip plugin"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r19"

SRC_URI = "git://github.com/rofafor/vdr-plugin-satip.git;branch=vdr-2.2.x"
SRCREV = "0bad1c1702ed85db7500755e126592d7672ea20e"

S = "${WORKDIR}/git"

inherit pkgconfig gettext

DEPENDS = " \
	vdr \
	curl \
	pugixml \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' \
	STRIP=/bin/true \
'

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

