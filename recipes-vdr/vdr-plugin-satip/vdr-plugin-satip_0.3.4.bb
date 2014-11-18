SUMMARY = "VDR satip plugin"
AUTHOR = "Rolf Ahrenberg"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r0"

SRC_URI = "http://www.saunalahti.fi/~rahrenbe/vdr/satip/vdr-satip-${PV}.tgz \
           file://make-strip.patch"

SRC_URI[md5sum] = "98a736c5bab7e67eb2a69d49db7a16ee"                                                                                                                                                  
SRC_URI[sha256sum] = "81dbd46d086dd2ef6856e0b515f4ccd3b58ceb11970d250d262db20ad5d7cfed"  

S = "${WORKDIR}/satip-${PV}"

DEPENDS = " \
	vdr \
	curl \
	libtinyxml \
"

EXTRA_OEMAKE = ' \
	SATIP_USE_TINYXML=1 \
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

