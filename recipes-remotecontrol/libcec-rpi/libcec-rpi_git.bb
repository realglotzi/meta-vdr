DESCRIPTION = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

COMPATIBLE_MACHINE = "(raspberrypi|raspberrypi2)"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e61fd86f9c947b430126181da2c6c715"

DEPENDS = "udev lockdev userland virtual/libgl libxrandr libxrender p8-platform"

PR="r2"

SRCREV = "2f625959a43ac68acce70f4e574b6357fe77a273"
SRC_URI = "git://github.com/Pulse-Eight/libcec.git \
           file://rpi.patch"

S = "${WORKDIR}/git"

inherit autotools pkgconfig cmake

# cec-client and xbmc need the .so present to work :(
FILES_${PN} += "${libdir}/*.so"
INSANE_SKIP_${PN} = "dev-so"

EXTRA_OECMAKE = "-DHAVE_RPI_API=1 \
	-DRPI_INCLUDE_DIR=${STAGING_DIR_HOST}/usr/include \
	-DRPI_LIB_DIR=${STAGING_DIR_HOST}/usr/lib \
	" 

LDFLAGS = " -L${STAGING_DIR_HOST}/usr/lib -L${STAGING_DIR_HOST}/usr/lib "

