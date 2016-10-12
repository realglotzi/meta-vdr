DESCRIPTION = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

COMPATIBLE_MACHINE = "(raspberrypi|raspberrypi2|raspberrypi3)"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e61fd86f9c947b430126181da2c6c715"

DEPENDS = "udev lockdev userland virtual/libgl p8-platform"

PR="r4"

SRCREV = "62b8520cf801343d93e8427393d3d929e59d9c7e"
SRC_URI = "git://github.com/Pulse-Eight/libcec.git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig cmake

EXTRA_OECMAKE = "-DHAVE_RPI_API=1 \
	-DSKIP_PYTHON_WRAPPER=1 \
	-DHAVE_RANDR=0 \
	-DRPI_INCLUDE_DIR=${STAGING_DIR_HOST}/usr/include \
	-DRPI_LIB_DIR=${STAGING_DIR_HOST}/usr/lib \
	"
