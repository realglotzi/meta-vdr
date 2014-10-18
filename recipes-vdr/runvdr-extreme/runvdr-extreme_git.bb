SUMMARY = "runvdr-extreme start script"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=e673a95e6911049cc1cadf00eac1f759"

SRCREV = "f029de7198f92e2583d1065bc2a8b518aa18daf4"
SRC_URI = "git://projects.vdr-developer.org/runvdr-extreme.git \
           file://init \
		  "

PR="r0"

S = "${WORKDIR}/git"

inherit update-rc.d

INITSCRIPT_NAME = "runvdr-extreme"
INITSCRIPT_PARAMS = "defaults 20" 

DEPENDS = " \
	procps \
	console-tools \
	util-linux \
"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" \
'

do_install() {
    install -d ${D}${bindir}/                                                                                                                                                                                  
    install -m 0755 ${S}/runvdr ${D}${bindir}/runvdr-extreme
		
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/runvdr-extreme
}																																													
 
FILES_${PN} = " \
	${bindir}/runvdr-extreme \
	${sysconfdir}/init.d/runvdr-extreme \
"

