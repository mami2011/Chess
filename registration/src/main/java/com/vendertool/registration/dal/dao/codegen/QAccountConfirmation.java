package com.vendertool.registration.dal.dao.codegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAccountConfirmation is a Querydsl query type for QAccountConfirmation
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QAccountConfirmation extends com.mysema.query.sql.RelationalPathBase<QAccountConfirmation> {

    private static final long serialVersionUID = -955598887;

    public static final QAccountConfirmation accountConfirmation = new QAccountConfirmation("account_confirmation");

    public final NumberPath<Long> accountConfirmationId = createNumber("account_confirmation_id", Long.class);

    public final NumberPath<Long> accountId = createNumber("account_id", Long.class);

    public final NumberPath<Short> confirmationCode = createNumber("confirmation_code", Short.class);

    public final DateTimePath<java.sql.Timestamp> confirmationDate = createDateTime("confirmation_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> expiryDate = createDateTime("expiry_date", java.sql.Timestamp.class);

    public final NumberPath<Byte> lastModifiedApp = createNumber("last_modified_app", Byte.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<Byte> numberOfAttempts = createNumber("number_of_attempts", Byte.class);

    public final StringPath sessionId = createString("session_id");

    public final com.mysema.query.sql.PrimaryKey<QAccountConfirmation> primary = createPrimaryKey(accountConfirmationId);

    public QAccountConfirmation(String variable) {
        super(QAccountConfirmation.class, forVariable(variable), "null", "account_confirmation");
    }

    @SuppressWarnings("all")
    public QAccountConfirmation(Path<? extends QAccountConfirmation> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "account_confirmation");
    }

    public QAccountConfirmation(PathMetadata<?> metadata) {
        super(QAccountConfirmation.class, metadata, "null", "account_confirmation");
    }

}

