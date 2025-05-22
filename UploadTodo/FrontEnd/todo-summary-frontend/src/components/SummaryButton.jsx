import React, { useState } from 'react';
import { summarizeTodos } from '../services/api';

function SummaryButton() {
  const [status, setStatus] = useState('');

  const handleSummarize = async () => {
    try {
      const response = await summarizeTodos();
      setStatus("✅ Summary sent to Slack!");
    } catch (e) {
      setStatus("❌ Failed to send summary.");
    }
  };

  return (
    <div>
      <button onClick={handleSummarize}>Summarize & Send to Slack</button>
      <p>{status}</p>
    </div>
  );
}

export default SummaryButton;
