SUMMARY = "VDR satip plugin"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r17"

SRC_URI = "git://github.com/rofafor/vdr-plugin-satip.git"
SRCREV = "6c4c8a10b75e882f0e83854f19f12b3db6812ee6"

S = "${WORKDIR}/git"

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

