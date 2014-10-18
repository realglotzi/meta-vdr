DESCRIPTION = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

COMPATIBLE_MACHINE = "raspberrypi"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=5e8e16396992369f73f3d28875f846da"

DEPENDS = "udev lockdev userland virtual/libgl"

SRCREV = "a560d244101d963b2f3e8a25a71aafb9e36ffb53"

SRC_URI = "git://github.com/Pulse-Eight/libcec.git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

# cec-client and xbmc need the .so present to work :(
FILES_${PN} += "${libdir}/*.so"
INSANE_SKIP_${PN} = "dev-so"

EXTRA_OECONF = "--enable-rpi \
	--with-rpi-include-path=${STAGING_DIR_HOST}/usr/include \
	--with-rpi-lib-path=${STAGING_DIR_HOST}/usr/lib \
	" 

LDFLAGS = " -L${STAGING_DIR_HOST}/usr/lib -L${STAGING_DIR_HOST}/usr/lib "

