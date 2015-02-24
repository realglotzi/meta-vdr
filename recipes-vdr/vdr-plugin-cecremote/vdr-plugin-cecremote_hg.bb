SUMMARY = "VDR cecremote plugin"
AUTHOR = "Uli Eckhart"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r1"

SRCREV = "3bb447915fd9461df08ea6d370e82b5fe0bc77bb"
SRC_URI = "hg://hg.uli-eckhardt.de;module=cecremote;rev=${SRCREV}"

S = "${WORKDIR}/cecremote"

DEPENDS = " \
	vdr \
	pugixml \
	libcec-rpi \
"

EXTRA_OEMAKE = 'INCLUDES=-I${STAGING_INCDIR}/libcec'

do_compile_prepend() {
	mkdir -p ${S}/po
}

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

