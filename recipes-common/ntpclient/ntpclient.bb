SUMMARY = "NTPClient"
DESCRIPTION = "ntpclient is an NTP (RFC-1305) client for unix-alike computers. Its functionality is a small subset of xntpd, but IMHO performs better (or at least has the potential to function better) within that limited scope. Since it is much smaller than xntpd, it is also more relevant for embedded computers. "
HOMEPAGE = "http://doolittle.icarus.com/ntpclient/"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://README;md5=098a6a289094e42f974b11e2151f5644"

PR = "r0"

SRC_URI = "http://doolittle.icarus.com/ntpclient/ntpclient_2010_365.tar.gz \
           file://init"

SRC_URI[md5sum] = "a64689398f2df8933ee0d8da246e9eaa"
SRC_URI[sha256sum] = "9ad9b028385082fb804167f464e2db0a0b3d33780acd399327e64898b8fcfddd"

S = "${WORKDIR}//ntpclient-2010"

inherit update-rc.d

INITSCRIPT_NAME = "ntpclient"
INITSCRIPT_PARAMS = "defaults 19" 

do_install() {
    install -d ${D}${bindir}/                                                                                                                                                                                  
    install -m 0755 ${S}/ntpclient ${D}${bindir}/
		
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ntpclient
}																																													

FILES_${PN} = "${bindir}/* ${sysconfdir}/init.d/ntpclient"