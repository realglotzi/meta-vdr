SUMMARY = "VDR satip plugin"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r8"

SRC_URI = "git://github.com/rofafor/vdr-plugin-satip.git"
SRCREV = "d2064f0c049911663c89e0262a5f725cd982af6c"

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

