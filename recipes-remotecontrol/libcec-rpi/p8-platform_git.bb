DESCRIPTION = "P8 Platform Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/src/os.h;beginline=21;md5=56563c1d1564ba87409393329327f049"

PR="r2"

SRCREV = "041a8c6cf4c44dbf0a8e295e3d3d2da13bbe0ad3"
SRC_URI = "git://github.com/Pulse-Eight/platform.git \
           file://fix_p8_libdir.patch"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DCMAKE_INSTALL_LIBDIR=/usr/lib \
                 -DCMAKE_INSTALL_LIBDIR_NOARCH=/usr/lib \
                 -DCCMAKE_INSTALL_PREFIX_TOOLCHAIN=${STAGING_DIR_HOST}/usr \
                 -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}/usr \
"
