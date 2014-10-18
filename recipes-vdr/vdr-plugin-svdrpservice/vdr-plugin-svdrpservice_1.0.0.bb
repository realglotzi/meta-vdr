SUMMARY = "This plugin offers SVDRP connections as a service to other plugins."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "http://vdr.schmirler.de/svdrpservice/vdr-svdrpservice-1.0.0.tgz"

SRC_URI[md5sum] = "b4debde708ed897e1b77152d6f00c571"                                                                                                                                                               
SRC_URI[sha256sum] = "c25147163c7abf864ca99d9d4c1a821242f3c4eddb658d8b691edb3f543818d8"  

S = "${WORKDIR}/svdrpservice-${PV}"

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

