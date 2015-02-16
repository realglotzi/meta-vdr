SUMMARY = "VDR satip plugin"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r10"

SRC_URI = "git://github.com/rofafor/vdr-plugin-satip.git"
SRCREV = "26cd34f965970972b668e02765e31314c6e58d7f"

S = "${WORKDIR}/git"

DEPENDS = " \
	vdr \
	curl \
	libtinyxml \
"

EXTRA_OEMAKE = ' \
	SATIP_USE_TINYXML=1 STRIP=/bin/true \
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

