SUMMARY = "Light-weight, simple and fast XML parser for C++ with XPath support"
HOMEPAGE = "http://pugixml.org"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;beginline=21;md5=d8c667fced84b09994455e766cbc00fe"

PR = "r2"

SRC_URI = "git://github.com/zeux/pugixml.git"
SRCREV = "d3b9e4e1e85d0aca562d0e6b62533e68e5a4a749"


S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS:BOOL=ON"

#FILES_${PN} = "${libdir}/libpugixml.*"
FILES_${PN} = "${libdir}/libpugixml.* ${libdir}/cmake/pugixml ${includedir}"
