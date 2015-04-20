SUMMARY = "VDR remote plugin"
AUTHOR = "Oliver Endriss"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR="r4"

SRC_URI = "http://www.escape-edv.de/endriss/vdr/vdr-remote-${PV}.tgz \
           file://55-x10.rules"

SRC_URI[md5sum] = "5c6e60e9a4a0d42ca2b93f3342452202"
SRC_URI[sha256sum] = "c05d17f207bd2723ae6c079bc8961ba0badfcced149afbea63a5c52c807de254"

S = "${WORKDIR}/remote-${PV}"

DEPENDS = "vdr"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

do_install() {
	oe_runmake DESTDIR=${D} install

    install -d ${D}${sysconfdir}/udev/rules.d 
	install -m 0755 ${WORKDIR}/55-x10.rules ${D}${sysconfdir}/udev/rules.d 
}

FILES_${PN} += " \
	${libdir}/vdr/* \
	${sysconfdir}/udev/rules.d/55-x10.rules \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"

