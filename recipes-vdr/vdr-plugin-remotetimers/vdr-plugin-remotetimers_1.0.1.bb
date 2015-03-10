SUMMARY = "This plugin offers SVDRP connections as a service to other plugins."
AUTHOR = "Frank Schmirler"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR="r2"

SRC_URI = "http://vdr.schmirler.de/remotetimers/vdr-remotetimers-1.0.1.tgz \
           file://remotetimers-vdr2.1.2compat.patch"

SRC_URI[md5sum] = "aece17988ec1d62d3985390eabbcfdc9"                                                                                                                                                               
SRC_URI[sha256sum] = "c87fc8eabd70f42de57d6b0eb813487496f7ff809aedbcc492766fa6f1d06c17"  

S = "${WORKDIR}/remotetimers-${PV}"

DEPENDS = "vdr"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

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

