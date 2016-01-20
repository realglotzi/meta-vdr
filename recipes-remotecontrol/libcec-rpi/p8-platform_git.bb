DESCRIPTION = "P8 Platform Library"
HOMEPAGE = "http://libcec.pulse-eight.com/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/src/os.h;beginline=21;md5=56563c1d1564ba87409393329327f049"

PR="r1"

SRCREV = "38343e0acd6a636ac46139aa666aee4a8d1f13db"
SRC_URI = "git://github.com/Pulse-Eight/platform.git"

S = "${WORKDIR}/git"

inherit cmake
