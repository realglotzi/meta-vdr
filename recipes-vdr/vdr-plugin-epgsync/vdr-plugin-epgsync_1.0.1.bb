SUMMARY = "Imports the EPG of an other VDR."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "http://vdr.schmirler.de/epgsync/vdr-epgsync-1.0.1.tgz"

SRC_URI[md5sum] = "694024ecd7bb813d43620ded63fc3ab4"                                                                                                                                                               
SRC_URI[sha256sum] = "b9e57e9c2dbebf20d5d193c84e991ae6e3a941db4b5b45780e239210f31a51e2"  

S = "${WORKDIR}/epgsync-${PV}"

DEPENDS = " \
	vdr \
"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" \
'

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
