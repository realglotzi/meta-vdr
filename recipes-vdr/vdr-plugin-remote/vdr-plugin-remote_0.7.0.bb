SUMMARY = "VDR remote plugin"
AUTHOR = "Oliver Endriss"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR="r6"

SRC_URI = "http://www.escape-edv.de/endriss/vdr/vdr-remote-${PV}.tgz \
           file://55-x10.rules"

SRC_URI[md5sum] = "21989c0d244dc0de213134be4b8a4fdc"
SRC_URI[sha256sum] = "e90a065db896e030dbb8c8dd99b9b70f3e3ade1017bedcbe6c50e3ce53512af0"

S = "${WORKDIR}/remote-${PV}"

inherit pkgconfig gettext

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

