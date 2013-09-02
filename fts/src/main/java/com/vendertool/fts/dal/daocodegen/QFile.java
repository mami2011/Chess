package com.vendertool.fts.dal.daocodegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QFile is a Querydsl query type for QFile
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QFile extends com.mysema.query.sql.RelationalPathBase<QFile> {

    private static final long serialVersionUID = -2126541841;

    public static final QFile file = new QFile("file");

    public final NumberPath<Long> accountId = createNumber("account_id", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final StringPath fileGroupId = createString("file_group_id");

    public final NumberPath<Long> fileId = createNumber("file_id", Long.class);

    public final NumberPath<Byte> filesCountInGroup = createNumber("files_count_in_group", Byte.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final StringPath refUrl = createString("ref_url");

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final NumberPath<Byte> storageSource = createNumber("storage_source", Byte.class);

    public final NumberPath<Byte> useCase = createNumber("use_case", Byte.class);

    public final com.mysema.query.sql.PrimaryKey<QFile> primary = createPrimaryKey(fileId);

    public QFile(String variable) {
        super(QFile.class, forVariable(variable), "null", "file");
    }

    @SuppressWarnings("all")
    public QFile(Path<? extends QFile> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "file");
    }

    public QFile(PathMetadata<?> metadata) {
        super(QFile.class, metadata, "null", "file");
    }

}

