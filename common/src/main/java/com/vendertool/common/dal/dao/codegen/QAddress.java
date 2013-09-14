package com.vendertool.common.dal.dao.codegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAddress is a Querydsl query type for QBeanAddress
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QAddress extends com.mysema.query.sql.RelationalPathBase<QBeanAddress> {

    private static final long serialVersionUID = 95222565;

    public static final QAddress address = new QAddress("address");

    public final StringPath addrLn1 = createString("addr_ln1");

    public final StringPath addrLn2 = createString("addr_ln2");

    public final StringPath addrLn3 = createString("addr_ln3");

    public final NumberPath<Byte> addrType = createNumber("addr_type", Byte.class);

    public final NumberPath<Long> addressId = createNumber("address_id", Long.class);

    public final StringPath city = createString("city");

    public final StringPath companyName = createString("company_name");

    public final StringPath contactFirstName = createString("contact_first_name");

    public final StringPath contactLastName = createString("contact_last_name");

    public final StringPath countryCodeIso3 = createString("country_code_iso3");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final StringPath postalCode = createString("postal_code");

    public final StringPath state = createString("state");

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final NumberPath<Byte> useCase = createNumber("use_case", Byte.class);

    public final com.mysema.query.sql.PrimaryKey<QBeanAddress> primary = createPrimaryKey(addressId);

    public QAddress(String variable) {
        super(QBeanAddress.class, forVariable(variable), "null", "address");
    }

    @SuppressWarnings("all")
    public QAddress(Path<? extends QBeanAddress> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "address");
    }

    public QAddress(PathMetadata<?> metadata) {
        super(QBeanAddress.class, metadata, "null", "address");
    }

}

