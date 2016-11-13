package com.axway.tnt.system.common;

import javax.xml.namespace.QName;

import com.axway.tnt.shared.Namespaces;
import com.axway.tnt.system.common.SystemTestExtension;

public enum SystemTestExtension {
	
	EXPIRATIONDATE(Namespaces.AXWAY, "expirationDate"), //
	LOTNUMBER(Namespaces.AXWAY, "lotNumber"), //
	QUANTITY(Namespaces.AXWAY, "quantity1"), //
	PRODUCTIONDATE(Namespaces.AXWAY, "productionDate"), //
	EXT1(Namespaces.EPCIS, "EXT1"),
	EXT2(Namespaces.EPCIS, "EXT2"),
	EXT3(Namespaces.EPCIS, "EXT3"),
	EXT4(Namespaces.EPCIS, "EXT4"),
	EXT5(Namespaces.EPCIS, "EXT5"),
	EXT6(Namespaces.EPCIS, "EXT6"),
	EXT7(Namespaces.EPCIS, "EXT7"),
	EXT8(Namespaces.EPCIS, "EXT8"),
	EXT9(Namespaces.EPCIS, "EXT9"),
	EXT10(Namespaces.EPCIS, "EXT10"),
    EXT11(Namespaces.EPCIS, "EXT11"),
	EXT12(Namespaces.EPCIS, "EXT12"),
	EXT13(Namespaces.EPCIS, "EXT13"),
	EXT14(Namespaces.EPCIS, "EXT14"),
	EXT15(Namespaces.EPCIS, "EXT15"),
	EXT16(Namespaces.EPCIS, "EXT16");
	public static SystemTestExtension fromExtensionName(
			final String extensionName) {
		for (final SystemTestExtension value : values()) {
			if (value.extensionName().equals(extensionName)) {
				return value;
			}
		}
		return null;
	}

	private final String extensionName;

	private final QName qualifiedName;

	private SystemTestExtension(final String namespaceURI, final String localPart) {
		qualifiedName = new QName(namespaceURI, localPart);
		extensionName = namespaceURI + "#" + localPart;
	}

	public String extensionName() {
		return extensionName;
	}

	public QName qualifiedName() {
		return qualifiedName;
	}
}
