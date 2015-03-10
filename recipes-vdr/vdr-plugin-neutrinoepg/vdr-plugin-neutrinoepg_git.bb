SUMMARY = "VDR neutrinoepg plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRCREV = "4fec4bcb560d4bd1e81585a0a4dfc7c4f31f6863"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-neutrinoepg.git"

PR="r2"

S = "${WORKDIR}/git"

DEPENDS = " \
	vdr \
    vdr-font-symbols \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} = " \
	${libdir}/vdr/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
