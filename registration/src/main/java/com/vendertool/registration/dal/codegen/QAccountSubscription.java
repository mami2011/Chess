package com.vendertool.registration.dal.codegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAccountSubscription is a Querydsl query type for QAccountSubscription
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QAccountSubscription extends com.mysema.query.sql.RelationalPathBase<QAccountSubscription> {

    private static final long serialVersionUID = 1581417665;

    public static final QAccountSubscription accountSubscription = new QAccountSubscription("account_subscription");

    public final NumberPath<Integer> accountId = createNumber("account_id", Integer.class);

    public final NumberPath<Integer> accountSubscriptionId = createNumber("account_subscription_id", Integer.class);

    public final StringPath changeWho = createString("change_who");

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("create_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> endDate = createDateTime("end_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> modifyDate = createDateTime("modify_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> startDate = createDateTime("start_date", java.sql.Timestamp.class);

    public final NumberPath<Integer> subscriptionId = createNumber("subscription_id", Integer.class);

    public final NumberPath<Short> subscriptionType = createNumber("subscription_type", Short.class);

    public final com.mysema.query.sql.PrimaryKey<QAccountSubscription> primary = createPrimaryKey(accountId, accountSubscriptionId);

    public final com.mysema.query.sql.ForeignKey<QSubscriptionDetail> accountSubscriptionSubscriptionDetail1Fk = createForeignKey(subscriptionId, "subscription_id");

    public QAccountSubscription(String variable) {
        super(QAccountSubscription.class, forVariable(variable), "null", "account_subscription");
    }

    @SuppressWarnings("all")
    public QAccountSubscription(Path<? extends QAccountSubscription> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "account_subscription");
    }

    public QAccountSubscription(PathMetadata<?> metadata) {
        super(QAccountSubscription.class, metadata, "null", "account_subscription");
    }

}

