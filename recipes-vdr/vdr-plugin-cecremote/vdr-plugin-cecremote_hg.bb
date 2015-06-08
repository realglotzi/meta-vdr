SUMMARY = "VDR cecremote plugin"
AUTHOR = "Uli Eckhart"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r8"

SRCREV = "4a2f17a6f0456ac638d67a3f1f27afb2c1395c4f"
SRC_URI = "hg://hg.uli-eckhardt.de;module=cecremote;rev=${SRCREV}"

S = "${WORKDIR}/cecremote"

DEPENDS = " \
	vdr \
	pugixml \
	libcec-rpi \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = 'INCLUDES=-I${STAGING_INCDIR}/libcec'

do_compile_prepend() {
	mkdir -p ${S}/po
}

do_install() {
	oe_runmake DESTDIR=${D} install-lib install-i18n
}

FILES_${PN} += " \
	${libdir}/vdr/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"

