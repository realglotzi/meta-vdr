SUMMARY = "Light-weight, simple and fast XML parser for C++ with XPath support"
HOMEPAGE = "http://pugixml.org"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;beginline=21;md5=6b597df90e70c0f4fa91695798fb3ede"

PR = "r3"

SRC_URI = "git://github.com/zeux/pugixml.git"
SRCREV = "0e3f1699ffab5f820060fe99c61f0f9495c0c5b6"


S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS:BOOL=ON"

#FILES_${PN} = "${libdir}/libpugixml.*"
FILES_${PN} = "${libdir}/libpugixml.* ${libdir}/cmake/pugixml ${includedir}"
