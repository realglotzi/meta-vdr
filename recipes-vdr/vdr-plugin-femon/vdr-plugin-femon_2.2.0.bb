SUMMARY = "DVB Frontend Status Monitor plugin for VDR"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r3"

SRC_URI = "http://www.saunalahti.fi/~rahrenbe/vdr/femon/files/vdr-femon-${PV}.tgz"

SRC_URI[md5sum] = "aab30ad1f44ee58c094f517b3bea48b2"
SRC_URI[sha256sum] = "226406ee222e86f9eb97beb6f8577d9d107d399a7bcdf9788103ee5418ec96e4"

S = "${WORKDIR}/femon-${PV}"

DEPENDS = "vdr"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' STRIP=/bin/true '

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

