DESCRIPTION = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

COMPATIBLE_MACHINE = "(raspberrypi|raspberrypi2)"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/src/os.h;beginline=21;md5=56563c1d1564ba87409393329327f049"

DEPENDS = "udev lockdev userland virtual/libgl libxrandr libxrender"

PR="r0"

SRCREV = "e1f8dc1b882069e52e6ead4380e3bb9b4792c398"
SRC_URI = "git://github.com/Pulse-Eight/platform.git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig cmake

# cec-client and xbmc need the .so present to work :(
FILES_${PN} += "${libdir}/*.so"
INSANE_SKIP_${PN} = "dev-so"

#EXTRA_OECONF = "--enable-rpi \
#
#	--with-rpi-include-path=${STAGING_DIR_HOST}/usr/include \
#	--with-rpi-lib-path=${STAGING_DIR_HOST}/usr/lib \
#	" 

#LDFLAGS = " -L${STAGING_DIR_HOST}/usr/lib -L${STAGING_DIR_HOST}/usr/lib "

