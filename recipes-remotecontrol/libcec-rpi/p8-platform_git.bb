DESCRIPTION = "P8 Platform Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/src/os.h;beginline=21;md5=56563c1d1564ba87409393329327f049"

PR="r3"

SRCREV = "a7cd0d5780ed80a4e70480d1650749f29e8a1fb2"
SRC_URI = "git://github.com/Pulse-Eight/platform.git"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DCMAKE_INSTALL_LIBDIR=/usr/lib \
                 -DCMAKE_INSTALL_LIBDIR_NOARCH=/usr/lib \
                 -DCCMAKE_INSTALL_PREFIX_TOOLCHAIN=${STAGING_DIR_HOST}/usr \
                 -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}/usr \
"
