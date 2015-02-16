SUMMARY = "VDR remote plugin"
AUTHOR = "Oliver Endriss"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR="r1"

SRC_URI = "http://www.escape-edv.de/endriss/vdr/vdr-remote-${PV}.tgz \
           file://55-x10.rules"

SRC_URI[md5sum] = "5807e553ef11c8c9fdc0e84b1ee67fb3"                                                                                                                                                               
SRC_URI[sha256sum] = "d643e7c55857daf675474905803b5561ea81c2ff39522916c8c3d25b890ac4a5"  

S = "${WORKDIR}/remote-${PV}"

DEPENDS = "vdr"

CXXFLAGS_append = " -fPIC "

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

