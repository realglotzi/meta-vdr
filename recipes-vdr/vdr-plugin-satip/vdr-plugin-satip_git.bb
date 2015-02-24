SUMMARY = "VDR satip plugin"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r13"

SRC_URI = "git://github.com/rofafor/vdr-plugin-satip.git"
SRCREV = "8184a785b7a504f909f1595114bb752d1dd8cb85"

S = "${WORKDIR}/git"

DEPENDS = " \
	vdr \
	curl \
	pugixml \
"

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

