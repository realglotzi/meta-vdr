SUMMARY = "VDR cecremote plugin"
AUTHOR = "Uli Eckhart"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r12"

SRCREV = "f3c8622ce46424e20729e735eb9e1f53841a064a"
SRC_URI = "git://git.uli-eckhardt.de/vdr-plugin-cecremote.git;protocol=http"

S = "${WORKDIR}/git"

inherit pkgconfig gettext

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

