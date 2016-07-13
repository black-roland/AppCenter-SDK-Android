package avalanche.base.ingestion.http;

import java.util.UUID;

import avalanche.base.ingestion.AvalancheIngestion;
import avalanche.base.ingestion.ServiceCall;
import avalanche.base.ingestion.ServiceCallback;
import avalanche.base.ingestion.models.LogContainer;

/**
 * Helper class used to share logic with multiple decorators.
 */
abstract class AvalancheIngestionCallDecorator implements Runnable, ServiceCall, ServiceCallback {

    /**
     * Decorated API.
     */
    final AvalancheIngestion mDecoratedApi;

    /**
     * Application identifier.
     */
    final UUID mAppKey;

    /**
     * Installation identifier.
     */
    final UUID mInstallId;

    /**
     * Log container.
     */
    final LogContainer mLogContainer;

    /**
     * Callback.
     */
    final ServiceCallback mServiceCallback;

    /**
     * Call.
     */
    ServiceCall mServiceCall;

    public AvalancheIngestionCallDecorator(AvalancheIngestion decoratedApi, UUID appKey, UUID installId, LogContainer logContainer, ServiceCallback serviceCallback) {
        mDecoratedApi = decoratedApi;
        mAppKey = appKey;
        mInstallId = installId;
        mLogContainer = logContainer;
        mServiceCallback = serviceCallback;
    }

    @Override
    public synchronized void cancel() {
        mServiceCall.cancel();
    }

    @Override
    public synchronized void run() {
        mServiceCall = mDecoratedApi.sendAsync(mAppKey, mInstallId, mLogContainer, this);
    }

    @Override
    public void success() {
        mServiceCallback.success();
    }
}