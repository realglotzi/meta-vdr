SUMMARY = "VDR graphlcd plugin"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=f73069ee5fe10af114e5300a37d32d44"

SRCREV = "5b5bf594f026fbcba2e31b423b43a2e5e45fd471"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-graphlcd.git;branch=touchcol \
          "

PR="r3"

S = "${WORKDIR}/git"

DEPENDS = " \
	graphlcd-base-ax206dpf \
	vdr \
"

CXXFLAGS_append = " -fPIC -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" INCLUDES=-I${STAGING_INCDIR} \
'

do_install() {
	oe_runmake DESTDIR=${D} install-lib install-i18n

	install -d ${D}${datadir}/vdr/plugins/graphlcd
	install -m 0755 ${S}/graphlcd/channels.alias ${D}${datadir}/vdr/plugins/graphlcd

	install -d ${D}${datadir}/vdr/plugins/graphlcd/logos
	install -d ${D}${datadir}/vdr/plugins/graphlcd/logos/channels
	install -d ${D}${datadir}/vdr/plugins/graphlcd/logos/channels/animated
	install -m 0755 ${S}/graphlcd/logos/channels/*.glcd          ${D}${datadir}/vdr/plugins/graphlcd/logos/channels
	install -m 0755 ${S}/graphlcd/logos/channels/animated/*.glcd ${D}${datadir}/vdr/plugins/graphlcd/logos/channels/animated

	install -d ${D}${datadir}/vdr/plugins/graphlcd/logos/replay
	install -d ${D}${datadir}/vdr/plugins/graphlcd/logos/replay/animated
	install -m 0755 ${S}/graphlcd/logos/replay/*.glcd          ${D}${datadir}/vdr/plugins/graphlcd/logos/replay
	install -m 0755 ${S}/graphlcd/logos/replay/animated/*.glcd ${D}${datadir}/vdr/plugins/graphlcd/logos/replay/animated

	install -d ${D}${datadir}/vdr/plugins/graphlcd/skins
	install -d ${D}${datadir}/vdr/plugins/graphlcd/skins/default
	install -d ${D}${datadir}/vdr/plugins/graphlcd/skins/default/images
	install -d ${D}${datadir}/vdr/plugins/graphlcd/skins/default/symbols
	install -m 0755 ${S}/graphlcd/skins/default/default.skin   ${D}${datadir}/vdr/plugins/graphlcd/skins/default
	install -m 0755 ${S}/graphlcd/skins/default/images/*.pbm   ${D}${datadir}/vdr/plugins/graphlcd/skins/default/images
	install -m 0755 ${S}/graphlcd/skins/default/symbols/*.pbm  ${D}${datadir}/vdr/plugins/graphlcd/skins/default/symbols

	install -d ${D}${datadir}/vdr/plugins/graphlcd/skins/touchcol
	install -d ${D}${datadir}/vdr/plugins/graphlcd/skins/touchcol/images
	install -d ${D}${datadir}/vdr/plugins/graphlcd/skins/touchcol/symbols
	install -m 0755 ${S}/graphlcd/skins/touchcol/touchcol.skin   ${D}${datadir}/vdr/plugins/graphlcd/skins/touchcol
	install -m 0755 ${S}/graphlcd/skins/touchcol/images/*.pbm    ${D}${datadir}/vdr/plugins/graphlcd/skins/touchcol/images
	install -m 0755 ${S}/graphlcd/skins/touchcol/symbols/*.pbm   ${D}${datadir}/vdr/plugins/graphlcd/skins/touchcol/symbols

	install -d ${D}${datadir}/vdr/plugins/graphlcd/fonts
	install -m 0755 ${S}/graphlcd/fonts/*.ttf ${D}${datadir}/vdr/plugins/graphlcd/fonts
	install -m 0755 ${S}/graphlcd/fonts/*.fnt ${D}${datadir}/vdr/plugins/graphlcd/fonts

}

FILES_${PN} = " \
	${libdir}/vdr/* \
	${datadir}/vdr/plugins/graphlcd/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"
