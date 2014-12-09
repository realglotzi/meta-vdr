DESCIPTION = "satip client for use with vtuner frontend"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PR = "r1"

SRCREV = "a72d5083b2a54c2611bb2039cda0a076500442f5"
SRC_URI = "git://code.google.com/p/satip;protocol=https \
           file://signal.patch" 

S = "${WORKDIR}/git/satip"

DEPENDS = "vtunerc"

do_install () {
        install -d ${D}${bindir}/
        install -m 0755 ${B}/satip ${D}${bindir}/satip-client
}
