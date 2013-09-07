package com.vendertool.registration.dal.dao.codegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPassswordHistory is a Querydsl query type for QPassswordHistory
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QPassswordHistory extends com.mysema.query.sql.RelationalPathBase<QPassswordHistory> {

    private static final long serialVersionUID = -679602155;

    public static final QPassswordHistory passswordHistory = new QPassswordHistory("passsword_history");

    public final NumberPath<Long> accountId = createNumber("account_id", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<Long> passswordHistoryId = createNumber("passsword_history_id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath salat = createString("salat");

    public final com.mysema.query.sql.PrimaryKey<QPassswordHistory> primary = createPrimaryKey(passswordHistoryId);

    public QPassswordHistory(String variable) {
        super(QPassswordHistory.class, forVariable(variable), "null", "passsword_history");
    }

    @SuppressWarnings("all")
    public QPassswordHistory(Path<? extends QPassswordHistory> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "passsword_history");
    }

    public QPassswordHistory(PathMetadata<?> metadata) {
        super(QPassswordHistory.class, metadata, "null", "passsword_history");
    }

}

