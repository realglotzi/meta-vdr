DESCRIPTION = "USB CEC Adaptor communication Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

COMPATIBLE_MACHINE = "(raspberrypi|raspberrypi2|raspberrypi3)"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b3a719e97f49e4841e90573f9b1a98ac"

DEPENDS = "udev lockdev userland virtual/libgl p8-platform"

PR="r5"

SRCREV = "76551ea1dd9a55f0ce1533e440dc12dbc594f7ba"
SRC_URI = "git://github.com/Pulse-Eight/libcec.git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig cmake

EXTRA_OECMAKE = "-DHAVE_RPI_API=1 \
	-DSKIP_PYTHON_WRAPPER=1 \
	-DHAVE_RANDR=0 \
	-DRPI_INCLUDE_DIR=${STAGING_DIR_HOST}/usr/include \
	-DRPI_LIB_DIR=${STAGING_DIR_HOST}/usr/lib \
	"
