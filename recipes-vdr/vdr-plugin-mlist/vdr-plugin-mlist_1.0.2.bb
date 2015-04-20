SUMMARY = "mlist plugin for VDR"
AUTHOR = "Joachim Wilke"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

PR = "r2"

SRC_URI = "https://github.com/jowi24/vdr-mlist/archive/1.0.2.tar.gz"

SRC_URI[md5sum] = "b356bf311309d97960bce879e574c4cb"
SRC_URI[sha256sum] = "62d069d87f75e32d10eec0d4e37a1a2294d361d244e37e062dc212500bfb49a3"

S = "${WORKDIR}/vdr-mlist-${PV}"

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

