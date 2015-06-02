SUMMARY = "Light-weight, simple and fast XML parser for C++ with XPath support"
HOMEPAGE = "http://pugixml.org"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;beginline=21;md5=b339f086b8738febdd0d31453f927ba9"

PR = "r1"

SRC_URI = "git://github.com/zeux/pugixml.git"
SRCREV = "708952d84ebaa1e6c5fa080596bf4a5357789d5d"


S = "${WORKDIR}/git/scripts"

inherit cmake

EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS:BOOL=ON"

#FILES_${PN} = "${libdir}/libpugixml.*"
FILES_${PN} = "${libdir}/libpugixml.* ${libdir}/cmake/pugixml ${includedir}"
