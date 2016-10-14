SUMMARY = "This is the base package of the GraphLCD project"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRCREV = "1e01a8963f9ab95ba40ddb44a6c166b8e546053d"
SRC_URI = "git://projects.vdr-developer.org/graphlcd-base.git;branch=touchcol \
           file://remove-legacy-devices.patch \
           file://graphlcd.conf \
          "
PR="r1"

S = "${WORKDIR}/git"

DEPENDS = " \
	libusb \
	freetype \
	imagemagick6 \
"
# GNU hash is missing, skip QA
INSANE_SKIP_${PN} = "ldflags"

EXTRA_OEMAKE = "DESTDIR=\"${D}\" 'INCLUDES=-I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/ImageMagick-6 -I${S}' LIBS=-L${STAGING_LIBDIR} 'LDFLAGS=-lfreetype -lMagick++-6.Q16 -lusb' HAVE_IMAGEMAGICK=1 HAVE_DRIVER_AX206DPF=1"

do_install() {
	install -d "${D}/${sysconfdir}"
	install -m 755 graphlcd.conf ${D}/${sysconfdir}

	install -d "${D}/${sysconfdir}/udev/rules.d/"
	oe_runmake DESTDIR=${D} BINDIR=${D}/${bindir} LIBDIR=${D}/${libdir} INCDIR=${D}/${includedir} UDEVRULESDIR="${D}/${sysconfdir}/udev/rules.d/" install
}

FILES_${PN} = " \
	${sysconfdir}/graphlcd.conf ${sysconfdir}/udev/rules.d ${bindir}/* ${libdir}/libglcd* ${includedir}/* \
"
