SUMMARY = "DVB Frontend Status Monitor plugin for VDR"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r0"

SRC_URI = "http://www.saunalahti.fi/~rahrenbe/vdr/femon/files/vdr-femon-${PV}.tgz \
           file://make-strip.patch"

SRC_URI[md5sum] = "bb004c3c54a88ca495b679a4318293c8"                                                                                                                  
SRC_URI[sha256sum] = "15fd4f26c8b8987b826ced60cbfb77517c028bf5c2536118d63a1a03eb767e2f"  

S = "${WORKDIR}/femon-${PV}"

DEPENDS = "vdr"

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

