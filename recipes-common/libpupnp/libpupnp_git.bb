DESCRIPTION = "The portable SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://pupnp.sourceforge.net/"
LIC_FILES_CHKSUM = "file://COPYING;md5=d41d8cd98f00b204e9800998ecf8427e"
LICENSE = "BSD"

PR = "r1"

LEAD_SONAME = "libupnp"
SRC_URI = "git://github.com/mrjimenez/pupnp"
SRCREV = "e99617fa2705affcecbaa8a2f151b4dd74222b22"

inherit autotools pkgconfig

S = "${WORKDIR}/git"

