SUMMARY = "mlist plugin for VDR"
AUTHOR = "Joachim Wilke"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

PR = "r0"

SRC_URI = "http://www.joachim-wilke.de/downloads/vdr-mlist/vdr-mlist-${PV}.tgz"

SRC_URI[md5sum] = "82f240fa8c73f52383444e3e6f477466"                                                                                                                                                  
SRC_URI[sha256sum] = "41be5daa9f65c3dcb288668458101bbd4f594f05414781395a7dc9c0c72503e1"  

S = "${WORKDIR}/mlist-${PV}"

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
