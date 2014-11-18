DESCRIPTION = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

COMPATIBLE_MACHINE = "raspberrypi"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e296fd6027598da75a7516ce1ae4f56a"

DEPENDS = "udev lockdev userland virtual/libgl"

PR="r0"

SRCREV = "70e1b5de433c01212742ca22a5874aafebcb5e94"
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

