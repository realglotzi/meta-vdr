SUMMARY = "Light-weight, simple and fast XML parser for C++ with XPath support"
HOMEPAGE = "http://pugixml.org"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;beginline=21;md5=1ef33537f64793f0579ca84a822d4fa2"

PR = "r0"

SRC_URI = "git://github.com/zeux/pugixml.git"
SRCREV = "ff16dbdd4c63fa46cc1f38eda4cfb66f38047657"


S = "${WORKDIR}/git/scripts"

inherit cmake

EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS:BOOL=ON"

#FILES_${PN} = "${libdir}/libpugixml.*"
FILES_${PN} = "${libdir}/libpugixml.* ${libdir}/cmake/pugixml ${includedir}"
