SUMMARY = "This plugin offers SVDRP connections as a service to other plugins."
AUTHOR = "Frank Schmirler"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR="r3"

SRC_URI = "http://vdr.schmirler.de/remotetimers/vdr-remotetimers-${PV}.tgz"

SRC_URI[md5sum] = "b3e7e8895d5e94362e8375882702cb83"                                                                                                                                                               
SRC_URI[sha256sum] = "cc8916695819f4bb9c02417a31f726e61f2e27da284a70ccefb50ee1e10242f1"  

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

